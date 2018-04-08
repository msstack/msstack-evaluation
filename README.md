## Evaluate MSstack
Evaluate performance different micro services frameworks

## Frameworks evaluated
1. wso2 msf4j
1. spring-boot

## How to compile
run `mvn clean package` and it will create an executable jar file inside target directory

## How to run
### Start zookeeper and kafka
1. Download [apache kafka](https://kafka.apache.org/downloads)
2. Start a ZooKeeper server. Kafka has a single node Zookeeper configuration built-in.
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```
3. Start kafka
```bash
bin/kafka-server-start.sh config/server.properties
```
4. Create required topics (order-created, item-added, order-finalized)
```bash
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic order-created-event
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic order-item-added-event
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic order-finalized-event
```