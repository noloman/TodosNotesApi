package com.nulltwenty.todosnotesapi.data

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "todo")
data class Todo(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(
        name = "uuid2",
        strategy = "uuid2"
    )
    @Column(columnDefinition = "varchar(36)")
    var id: String = "",
    var title: String,
    var message: String,
    var schedule: Long,
    var location: String = ""
) {
    constructor() : this(id = "", title = "", message = "", schedule = -1, location = "")
}