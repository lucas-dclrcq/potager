# Potager

The goal of this application is to help the gardening enthusiast to manage his square foot garden.

## Warning

This app is currently a work in progress, features are regularly added and it is very unstable at the moment.

## Roadmap

## Short term

- [ ] Create a garden 
- [ ] Define cultivatable squares
- [ ] Add plants to the inventory
- [ ] Add plants to squares

## Long-term

- [ ] Track events in the journal
- [ ] Track tasks in the journal
- [ ] Notify user on tasks/events
- [ ] Show garden past/future state 
- [ ] Authentication / user management without Keycloak

## Installation

*TODO*

## Development
This project uses Quarkus for the backend, and VueJS for the frontend.
### Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile exec:exec@npm-watch quarkus:dev
```

This will start everything needed :
- The backend with hot-reload
- The frontend with hot-reload
- Keycloak for authentication
- The postgresql database

There are two default users you can use to login:
- alice (password: alice)
- bob (password: bob)

## Building the application

*TODO*