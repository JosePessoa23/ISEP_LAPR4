#!/bin/bash
STOREPASS="forgotten"
for ENT in agvmanager_J agv1_J agv2_J agv3_J agv4_J agv5_J agv6_J; do
 rm -f ${ENT}.jks ${ENT}.pem
 echo -e "${ENT}\nDEI\nISEP\nPORTO\nPORTO\nPT\nyes" | keytool -genkey -v -alias ${ENT} -keyalg RSA -keysize 2048 \
	-validity 365 -keystore ${ENT}.jks -storepass ${STOREPASS}
 keytool -exportcert -alias ${ENT} -keystore ${ENT}.jks -storepass ${STOREPASS} -rfc -file ${ENT}.pem
done
####
echo "Creating trust relations"
### IMPORTING TRUSTED CERTIFICATES
### (The server trusts all clients except for agv4_J)
### (Every client trusts agvmanager_J)
for ENT in agv1_j agv2_J agv3_J agv4_J agv5_J agv6_J; do
 echo "yes"|keytool -import -alias ${ENT} -keystore agvmanager_J.jks -file ${ENT}.pem -storepass ${STOREPASS}
 echo "yes"|keytool -import -alias agvmanager_J -keystore ${ENT}.jks -file agvmanager_J.pem -storepass ${STOREPASS}
done
keytool -list -keystore agvmanager_J.jks -storepass ${STOREPASS}
#######
