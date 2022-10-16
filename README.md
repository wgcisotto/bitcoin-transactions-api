# Backend

Read deposits from the database that are good to credit to users and print the following 10 lines on stdout:

    ```
    Deposited for Wesley Crusher: count=n sum=x.xxxxxxxx
    Deposited for Leonard McCoy: count=n sum=x.xxxxxxxx
    Deposited for Jonathan Archer: count=n sum=x.xxxxxxxx
    Deposited for Jadzia Dax: count=n sum=x.xxxxxxxx
    Deposited for Montgomery Scott: count=n sum=x.xxxxxxxx
    Deposited for James T. Kirk: count=n sum=x.xxxxxxxx
    Deposited for Spock: count=n sum=x.xxxxxxxx
    Deposited without reference: count=n sum=x.xxxxxxxx
    Smallest valid deposit: x.xxxxxxxx
    Largest valid deposit: x.xxxxxxxx
    ```

### Compiling

* Linux:

    ```
    ./mvnw clean install dockerfile:build
    ```
* Windows:

    ```
    ./mvnw.cmd clean install dockerfile:build
    ```

_this command generate the image_