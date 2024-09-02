Welcome to my sandbox project !!!

```arm
docker build -f Dockerfile -t maravelias/myeconomics:tagname:0.0.1 .
```

Έπειτα εκτελούμε τη παρακάτω εντολή για να τρέξουμε το σύστημα μας

```arm
docker-compose -p myeconomics -f ./docker-compose.yaml  up
```
Αφού ολοκληρωθεί το παραπάνω σέ ένα  browser  ανοίγουμε το URL http://localhost:9003/
Εκεί εμφανίζετε το διαχειριστικό της βάσης δεδομένων μας 


For Grandle Build we run: 
```arm
grandle clean bootBuildImage -Pvaadin.productionMode=true
```
