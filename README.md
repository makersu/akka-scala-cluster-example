# akka-scala-cluster-example
Akka Cluster Server and Client example in scala

## Download Akka 2.4.8 http://akka.io/downloads/


## Run Server
### Start seed node 1
```
cd akka-scala-cluster-server
sbt run -Dcom.sun.management.jmxremote.port=9552 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false
```
### Star seed node 2
```
sbt run -Dakka.remote.netty.tcp.port=3310
```

## Run Client
```
cd akka-scala-cluster-client
sbt run
```

## Remove seed node 1 after client runing
```
bin/akka-cluster localhost 9552 leave akka.tcp://EarthClusterSystem@127.0.0.1:3309
```
