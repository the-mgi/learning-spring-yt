package com.themgi.lsp.respository

import com.themgi.lsp.domain.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DepartmentRepository : JpaRepository<Department, Long> {
    fun findByDepartmentName(departmentName: String): Optional<Department>
    fun findByDepartmentNameIgnoreCase(departmentName: String): Optional<Department>
}