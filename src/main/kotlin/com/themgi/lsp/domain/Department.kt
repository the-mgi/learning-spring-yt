package com.themgi.lsp.domain

import org.hibernate.validator.constraints.Length
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @NotBlank(message = "Please add departmentName")
    @Length(max = 5, min = 1)
    var departmentName: String? = null,

    var departmentAddress: String? = null,
    var departmentCode: String? = null
) {
    override fun toString(): String {
        return "Department(id=$id, departmentName=$departmentName, departmentAddress=$departmentAddress, departmentCode=$departmentCode)"
    }
}