# Test-Assignment-03

When connecting to DBeaver setup connection with username root and password testuser1234
docker run -d --rm --name mysql-test-db -e MYSQL_ROOT_PASSWORD=testuser1234 -e MYSQL_DATABASE=BookingTest -p 3307:3306 mysql