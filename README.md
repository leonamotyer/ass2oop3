Data Structures Implementation - Assignment 2
Project Overview
This Java project implements fundamental data structures as part of the CPRG 304-A Object-Oriented Programming course. It demonstrates practical applications of OOP principles through custom implementations of core data structures that form the backbone of modern software development.

Data Structures
MyStack
A last-in-first-out (LIFO) data structure implemented using an ArrayList foundation. Provides efficient push, pop, and peek operations with constant time complexity for most operations.

MyQueue
A first-in-first-out (FIFO) data structure built on a doubly-linked list implementation. Optimized for rapid enqueue and dequeue operations while maintaining data integrity throughout the structure's lifecycle.

MyArrayList
A dynamic array implementation that grows automatically as elements are added. Provides rapid random access to elements while handling the complexity of array resizing internally.

MyDLL (Double Linked List)
A bidirectional linked structure that enables efficient traversal in both directions. Optimized for rapid insertions and deletions at any position without requiring element shifting.

Project Structure
implementations - Contains the core data structure implementations
utilities - Houses interfaces and utility classes
exceptions - Custom exception classes for robust error handling
unitTests - Comprehensive test suite for verification of implementations
Getting Started
Prerequisites
JDK 8 or higher
Java IDE (Eclipse, IntelliJ IDEA, etc.)
Setup
Clone the repository as shown above
Open the project in your preferred IDE
Ensure all dependencies are correctly configured
XML Parser Usage
The project includes an XML parser that validates XML structure using the custom data structures implemented in this assignment.

Running the XML Parser
Compile the project in your IDE or using command line tools
Run the XMLAppDriver class with the path to an XML file as a command-line argument:
java appDomain.XMLAppDriver path/to/your/xmlfile.xml
How the XML Parser Works
The XML parser:

Reads the XML file line by line using the custom MyArrayList implementation
Extracts XML tags and processes them in sequence
Uses MyStack to track opening tags and validate proper nesting
Utilizes MyQueue to process the tags in the order they appear
Validates proper XML structure and reports any errors
Error Reporting
The parser will detect and report common XML errors including:
If errors are found, they will be displayed with line numbers and descriptions to help you locate and fix issues in your XML file.

Unclosed tags
Mismatched opening and closing tags
Improperly nested tags
Malformed XML syntax



Testing
The project includes a comprehensive test suite using JUnit. Each data structure has its own dedicated test class that verifies:
Core functionality
Edge cases
Exception handling
Performance characteristics
Performance Considerations
MyStack: O(1) operations for push/pop in most cases
MyQueue: O(1) complexity for enqueue/dequeue operations
MyArrayList: O(1) average time complexity for add/get with occasional O(n) for resizing
MyDLL: O(1) insertions and deletions at known positions, O(n) for finding elements
Contributors
Developed by: 
Leona Motyer 
Devonte Mclean 
Yoohyun Kim 
Gabrielle Alama
