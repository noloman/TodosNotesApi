package com.nulltwenty.todosnotesapi.data

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "note")
data class Note(
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
    var location: String = ""
) {
    constructor() : this(id = "", title = "", message = "", location = "")
}