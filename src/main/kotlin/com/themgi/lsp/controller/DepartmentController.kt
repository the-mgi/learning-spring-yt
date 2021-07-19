package com.themgi.lsp.controller

import com.themgi.lsp.domain.Department
import com.themgi.lsp.service.DepartmentService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/department")
class DepartmentController(
    @Autowired
    private var departmentService: DepartmentService
) {

    @PostMapping
    fun saveDepartment(@Valid @RequestBody department: Department): Department {
        LOGGER.info("in saveDepartment DepartmentController")
        return this.departmentService.saveDepartment(department)
    }

    @GetMapping
    fun getDepartments(): List<Department> {
        LOGGER.info("in getDepartments DepartmentController")
        return this.departmentService.fetchDepartments()
    }

    @GetMapping("/{id}")
    fun getDepartmentById(@PathVariable("id") id: Long): Optional<Department> {
        return this.departmentService.fetchDepartmentById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteDepartmentById(@PathVariable("id") id: Long): String {
        LOGGER.info("in deleteDepartmentById DepartmentController")
        this.departmentService.deleteDepartmentById(id)
        return "Department Deleted Successfully"
    }

    @PutMapping("/{id}")
    fun updateDepartment(@PathVariable("id") id: Long, @RequestBody department: Department): Department {
        LOGGER.info("in updateDepartment DepartmentController")
        return this.departmentService.updateDepartment(id, department)
    }

    @GetMapping("/name/{name}")
    fun fetchDepartmentByName(@PathVariable("name") departmentName: String): Optional<Department> {
        LOGGER.info("in fetchDepartmentByName DepartmentController")
        return this.departmentService.fetchDepartmentByName(departmentName)
    }

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(DepartmentController::class.java)
    }
}