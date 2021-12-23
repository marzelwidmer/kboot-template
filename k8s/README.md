# Helm 
## Install MongoDB
``` 
helm install mongodb bitnami/mongodb
```
### ReplicaSet
``` 
helm install mongodb --set architecture=replicaset bitnami/mongodb
```
## Install Redis
``` 
helm install redis bitnami/redis
```
### Standalone
``` 
helm install redis --set architecture=standalone bitnami/redis
```

## Install Prometheus
``` 
helm install prometheus --set prometheus.prometheusSpec.serviceMonitorSelectorNilUsesHelmValues=false  prometheus-community/kube-prometheus-stack
```

## Install Postgresql
```
helm install postgresql bitnami/postgresql
```
