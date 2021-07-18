package com.themgi.lsp.service

import com.themgi.lsp.domain.Department
import java.util.*

interface DepartmentService {
    fun saveDepartment(department: Department): Department
    fun fetchDepartments(): List<Department>
    fun fetchDepartmentById(id: Long): Optional<Department>
    fun deleteDepartmentById(id: Long)
    fun updateDepartment(id: Long, department: Department): Department
    fun fetchDepartmentByName(departmentName: String): Optional<Department>
}