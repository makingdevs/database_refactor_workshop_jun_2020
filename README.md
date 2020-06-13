# Welcome to Database Refactor Workshop

This workshop is intended to show one more practice for CI and CD, so, this is the chance for learning a new tecnhique for new and legacy systems with a relational database.

## Requeriments

- JDK 1.8+
- MySQL 5.5+
- A text editor

Simple!!! Right!!!

## Optional requirements

- Git for your convenience and control
- Groovy for an optimization
- Gradle 5.x+ for final integration with your systems

## Environment setup

- Download **liquibase** from the [website](https://www.liquibase.org/download).
- Add to your **PATH**, wherever you want Güin2, Linux, Mac, but only in the terminal
- Verify your installation:

```shell
_> liquibase --version
Starting Liquibase at vie, 12 jun 2020 20:12:54 CDT (version 3.10.0 #10 built at Thu Jun 11 09:47:49 UTC 2020)
Liquibase Version: 3.10.0
Liquibase Community 3.10.0 by Datical
Running Java under /Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre (Version 1.8.0_181)
```

## Database setup

Well, it's easy:

- Create a database `makingdevs_demo_db`

```shell
 mysql -u makingdevs -pmakingdevs -h 0.0.0.0 makingdevs_demo_db < create-schema-mysql.sql
```

## Exercises in this workshop

1. So we're going to rename a table
  * Rename the `inv` table to `invoice`
  * Rename the `lineitem` table to `line_item`
  * Rename the `lidetail` table to `line_item_detail`
2. Rename some columns in the `invoice` table
  * Rename `invid` to `id`
  * Rename `invnumber` to `invoice_number`
  * Rename `datetimecreated` to `date_created`
3. We're going to combine two columns using data transformation
  * `invoice.udtime` and `invoice.uddate` should be combined into `invoice.date_updated`
  * First populate the `date_created` new column with an `UPDATE` query that merges the `udtime` and `uddate` values
    * HINT: `udtime` + `uddate`
  * What do you think about this refactoring?
    * drop or kept them?
4. Create tables
  * `contact_ball_of_mud` is too ambitious of a table (or insufficiently coherent). Let's begin splitting it up.
    * The **contact** table should contain name fields, gender, email address, street address, birthday, occupation, and national ID
    * The **security_info** table should contain password and mother's maiden name
    * The **credit_card** table should contain credit card type, number, expiration and CVV
    * Choice of data type for each column is left as an exercise for the student.
  * Don't run this refactoring yet!
5. Tagging and rolling back
  * Tag the database, then run the table rename refactoring written in the previous step
  * Now roll back to continue development on the refactoring
6. Finish refactoring of `contact_ball_of_mud`
  * Write data transformation code to populate the three tables from their source
  * Remember that `security_info` and `credit_card` should have foreign keys to contact. Be sure to add these constraints with the appropriate refactorings
7. Add a column
  * Add a `full_name` column to contact
  * Write data transformation SQL to populate it with the three existing name fields combined
    * HINT: `CONCAT_WS()`
  * Don't drop of the source name columns.
8. Create a trigger
  * Create a file called __contact_insert.sql__
    * Write trigger logic to keep `full_name` up to date with the fields for first name, middle initial, and last name every time a new record is inserted
  * Create a file called *contact_update.sql*
    * Same logic as the insert trigger
  * Write changeSets that use the sqlFile refactoring to install these triggers.
    * Remember the runOnChange attribute.
    * HINT: be sure the changeSet is idempotent!
9. Use **gradle**, this is the thing that you should to do...
  * Restart the steps but now with gradle
  * Use the Groovy DSL for the new migrations
10. Introduce surrogate key
  * Add an auto\-incrementing column to line_item called id.
  * Add a primary key constraint on id.
