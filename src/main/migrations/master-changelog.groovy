databaseChangeLog {
  include file: "src/main/migrations/database.changelog.xml"
  include file: "src/main/migrations/rename-tables.xml"
  include file: "src/main/migrations/rename-columns.yml"
  include file: "src/main/migrations/merge-columns.sql"
  changeSet(author: "neodevelop", id: "202006131124-8") {
    tagDatabase(tag: "version_1.0")
  }
  include file: "src/main/migrations/split-table.xml"
  changeSet(author: "neodevelop", id: "202006131131-12") {
    tagDatabase(tag: "version_1.1")
  }
  include file: "src/main/migrations/relation-tables.xml"
  include file: "src/main/migrations/migrate-data.xml"
  changeSet(author: "neodevelop", id: "2020152000-20") {
    tagDatabase(tag: "version_1.2")
  }
  include file: "src/main/migrations/add-fullname-to-contact.groovy"
}
