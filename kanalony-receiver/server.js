'use strict';

var http      = require('http'),
    kanalony  = require('./kanalony'),
    timeUtil  = kanalony.TimeUtil,
    config    = kanalony.ConfigurationUtil,
    logger    = kanalony.Logger(module),
    relay     = new kanalony.EventsRelay(config.getOrElse('kanalony.zookeeper.connection_string','127.0.0.1:2181/'),
                                         config.getOrElse('kanalony.zookeeper.topic','player-events')),
    host      = config.getOrElse('kanalony.receiver.host','0.0.0.0'),
    port      = config.getOrElse('kanalony.receiver.port','5555');

http.createServer(function (req, res) {
    if (relay.isRequestValid(req)){
        res.writeHead(200, {'Content-Type': 'text/plain'});
        res.end(timeUtil.currentDateTimeAsUTCString());
        relay.produceEvent(req, function(err){
            // TODO - Handle Kafka errors
            if (err) { };

        });
    }
    else {
        if (err) { logger.error(timeUtil.currentDateTimeAsUTCString(), err); }
        res.writeHead(400, {'Content-Type': 'text/plain'});
        return res.end("Bad request");
    }

}).listen(port, host);

logger.info('Server is running at http://' + host + ':' + port + '/');

