### Installing homework2 via helm

```bash
kubectl create namespace homework2-helm
helm install homework2 homework-helm -n homework2-helm
```

### Running POSTMAN collection

```
newman run  Users\ CRUD.postman_collection.json
```
