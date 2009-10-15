package leapstream.scoreboard.alien.clobber.core;

import au.net.netstorm.boost.spider.api.config.mapping.Mapper;
import au.net.netstorm.boost.spider.api.config.web.Web;
import au.net.netstorm.boost.spider.api.config.wire.Wire;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.clobber.read.parse.NameMapper;
import leapstream.scoreboard.alien.clobber.read.parse.TypeMapper;

// FIX 1202 Jan 14, 2009 Delete once boost clobber is complete.
public final class ClobberWeb implements Web {
    String scope = "leapstream.scoreboard";
    Wire wire;
    Mapper mapper;
    Nu nu;

    public void web() {
        // FIX 1596 Dec 30, 2008 Revisit. Pattern for declaring this.
        mapper.prefix("Default", "leapstream.scoreboard.alien.clobber");
        // FIX 1596 Dec 30, 2008 Should not be here. Move out and kill this.
        mapper.prefix("Default", "leapstream.scoreboard.alien");
        TypeMapper typer = nu.nu(TypeMapper.class);
        NameMapper namer = nu.nu(NameMapper.class, "leapstream.scoreboard.core.model");
        typer.add(namer);
        wire.ref(typer).to(TypeMapper.class);
    }
}