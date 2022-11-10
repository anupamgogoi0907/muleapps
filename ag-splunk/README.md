# Extract certificate of Splunk
```
openssl s_client -showcerts -connect localhost:8088 </dev/null
```

# Check CN of the Splunk

# Import certificate to truststore
```
keytool -keystore truststore.jks -alias splunk -import -file splunkserverdefaultcert.pem
```


docker run -p 8000:8000 -p 8088:8088 \
             -e "SPLUNK_PASSWORD=admin1234" \
             -e "SPLUNK_START_ARGS=--accept-license" \
             --name splunk \
             -d splunk/splunk:latest
