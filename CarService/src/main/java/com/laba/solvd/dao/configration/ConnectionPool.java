package com.laba.solvd.dao.configration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static ConnectionPool instance;
    private final List<Connection> connections;

    private ConnectionPool() {
        try {
            Class.forName(Config.DRIVER.getValue());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver class is not found", e);
        }

        int connectionPoolSize = Integer.parseInt(Config.POOL_SIZE.getValue());
        this.connections = new ArrayList<>(connectionPoolSize);
        for (int i = 0; i < connectionPoolSize; i++) {
            connections.add(createConnection());
        }
    }

    private Connection createConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(
                    Config.URL.getValue(),
                    Config.USERNAME.getValue(),
                    Config.PASSWORD.getValue()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create connection", e);
        }
        return connection;
    }

    public Connection getConnection() {
        synchronized (connections) {
            if (connections.isEmpty()) {
                try {
                    connections.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Unable to get connection", e);
                }
            }
            return connections.remove(connections.size() - 1);
        }
    }

    public void releaseConnection(Connection connection) {
        synchronized (connections) {
            connections.add(connection);
            connections.notifyAll();
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }
}