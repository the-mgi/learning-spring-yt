package com.themgi.lsp.service

import com.themgi.lsp.domain.Department
import com.themgi.lsp.error.DepartmentNotFoundException
import com.themgi.lsp.respository.DepartmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DepartmentServiceImplementation(@Autowired private var departmentRepository: DepartmentRepository) :
    DepartmentService {
    override fun saveDepartment(department: Department): Department {
        return this.departmentRepository.save(department)
    }

    override fun fetchDepartments(): List<Department> {
        return this.departmentRepository.findAll()
    }

    override fun fetchDepartmentById(id: Long): Optional<Department> {
        val optional = this.departmentRepository.findById(id)
        if(!optional.isPresent) {
            throw DepartmentNotFoundException()
        }
        return optional
    }

    override fun deleteDepartmentById(id: Long) {
        return this.departmentRepository.deleteById(id)
    }

    override fun updateDepartment(id: Long, department: Department): Department {
        department.id = id
        return this.departmentRepository.save(department)
    }

    override fun fetchDepartmentByName(departmentName: String): Optional<Department> {
        return this.departmentRepository.findByDepartmentNameIgnoreCase(departmentName)
    }
}