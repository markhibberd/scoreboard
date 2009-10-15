#!/usr/bin/ruby

require 'rubygems'
require 'hpricot'
require 'net/http'
require 'uri'
require 'time'

PROJECT_ID = 4989

puts "Content-Type: text/html"
puts

#cache = '/tmp/pivotal.xml'
#if !File.exists? cache or ((Time.now - File.mtime(cache)).to_i > 100)
#  $stderr.puts "Fetching"
  resource_uri = URI.parse("http://www.pivotaltracker.com/services/v2/projects/#{PROJECT_ID}/stories")
  response = Net::HTTP.start(resource_uri.host, resource_uri.port) do |http|
    http.get(resource_uri.path, {'X-TrackerToken' => 'b56c04a73706c881791827272aca8f59'})
  end
#  File.open(cache,'w') { |out| out.puts response.body }
#end

result_mapper = Hash.new { |h,k| h[k] = "ERROR" }.merge({"accepted" => "SUCCESS", "unstarted" => "FAILURE"})
#doc = Hpricot(IO.read(cache))
doc = Hpricot(response.body)

timestamp = Time.now.to_i

#name=#{story.at(:name).inner_text}
runs = (doc/:story).select { |story|
  !(story/:iteration).empty?
}.select { |story|
  start = Time.parse((story/:iteration/:start).inner_text).to_i
  finish = Time.parse((story/:iteration/:finish).inner_text).to_i
  range = Range.new(start,finish)
#  $stderr.puts "#{timestamp} === #{range} => #{range.include? timestamp}"
  range.include? timestamp
}.map { |story|
  timestamp
  %Q{Run[
        timestamp=TimePoint[#{Time.parse((story/:created_at).inner_text).to_i}]
        id=Id[#{(story/:id).inner_text}]
        result=SUCCESS
    ]}
}
#result=#{result_mapper[(story/:current_state).inner_text]}

puts %Q{Score[
    name=Name[pivotal_cards]
    timestamp=TimePoint[#{timestamp}]
    status=Status[
        is=WAITING
        since=TimePoint[#{timestamp - 10000}]
    ]
    history=History[[#{runs.join(', ')}]]
]
}