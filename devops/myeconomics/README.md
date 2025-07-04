# MyEconomics Development Environment

This directory contains the Docker Compose configuration for setting up a development environment for the MyEconomics application.

## Components

The development environment consists of the following components:

### Services

1. **PostgreSQL Database (postgres)**
   - Container name: postgres
   - Image: postgres:16.4
   - Ports:
     - 5431:5432 (alternative port)
     - 5432:5432 (default port)
   - Default credentials:
     - Username: postgres
     - Password: p@ssw0rd!
     - Database: myeconomics

2. **pgAdmin (pgadmin)**
   - Container name: pgadmin
   - Image: dpage/pgadmin4:8.12.0
   - Port: 8982:80
   - Default credentials:
     - Email: giorgos@maravelias.eu
     - Password: admin

### Network

- **myeconomics_network**: A bridge network that allows the containers to communicate with each other.
  - Subnet: 10.10.1.0/24
  - Static IP Assignments:
    - postgres: 10.10.1.2
    - pgadmin: 10.10.1.3

### Volumes

1. **myeconomics_db_data**: Persistent storage for the PostgreSQL database.
2. **myeconomics_pgadmin**: Persistent storage for pgAdmin configuration and data.

## Usage

### Starting the Environment

To start the development environment, run the following command from this directory:

```bash
docker-compose up -d
```

This will start all the services in detached mode.

### Stopping the Environment

To stop the environment, run:

```bash
docker-compose down
```

To stop the environment and remove all volumes (this will delete all data), run:

```bash
docker-compose down -v
```

### Accessing the Services

- **PostgreSQL**: Connect to the database using a PostgreSQL client at localhost:5432 or localhost:5431
- **pgAdmin**: Access the pgAdmin web interface at http://localhost:8982

## Connecting to the Database from pgAdmin

1. Open pgAdmin at http://localhost:8982
2. Log in with the credentials specified above
3. Add a new server with the following details:
   - Name: MyEconomics
   - Host: postgres (use the container name as they are on the same network)
   - Port: 5432
   - Username: postgres
   - Password: p@ssw0rd!
