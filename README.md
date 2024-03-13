This project was created on 9 May 2023

Java ServerSocket Application for GCD Calculation

Description

This Java project implements a server application that uses ServerSockets to establish connections with clients, processes incoming messages, and performs Greatest Common Divisor (GCD) calculations. It demonstrates network programming with ServerSockets and concurrency in Java to handle multiple client connections simultaneously.

Key Learnings

Network Programming with ServerSockets: Utilized ServerSockets in Java for network communication between the server and clients.
Concurrency in Network Applications: Employed an executor service and threads to manage concurrent client connections effectively.
Algorithm Implementation and Network Integration: Implemented the GCD algorithm and integrated it with network operations, processing client requests and sending responses.
Getting Started

Dependencies
Java JDK 8 or higher.
Running the Application
Compile the Server.java and SocketHandler.java files.
Execute Server.java to start the server on port 8189.
Server Functionality

Listens on port 8189 for client connections.
Processes specific commands from clients and responds with GCD calculations.
Handles multiple client connections concurrently, providing real-time responses.
