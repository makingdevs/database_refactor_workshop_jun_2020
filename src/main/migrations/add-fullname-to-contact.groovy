databaseChangeLog {
  changeSet(author: "neodevelop", id: "202006152000-21"){
    addColumn(tableName: "contact"){
      column(name: "full_name", afterColumn: "surname", type: "varchar(255)")
    }
    rollback {
      dropColumn(columnName: "full_name", tableName: "contact")
    }
  }
  changeSet(author: "neodevelop", id: "202006152000-22"){
    sql """
      update contact set full_name=concat_ws(' ', givenname, middleinitial, surname);
    """
    rollback()
  }
}
