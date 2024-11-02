import React, { useState, useEffect } from "react";
import employeeService from "./services/employees";
import EmployeeList from "./components/employeeList/EmployeeList.jsx";
import EmployeePage from "./components/EmployeePage.jsx";
import AddEmployeeForm from "./components/AddEmployeeForm.jsx";

const App = () => {
  const [employees, setEmployees] = useState([]);
  const [selectedEmployee, setSelectedEmployee] = useState(null);
  const [addNewEmployee, setAddNewEmployee] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phone: "",
  });

  useEffect(() => {
    employeeService
      .getAllEmployees()
      .then((response) => {
        setEmployees(response._embedded.employeeList);
      })
      .catch((error) => console.log("Error fetching employees: ", error));
  }, []);

  const handleSelectEmployee = (employee) => {
    setSelectedEmployee(employee);
  };

  const handleBackToList = () => {
    setSelectedEmployee(null);
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    console.log(e.target.value);
    setAddNewEmployee({ ...addNewEmployee, [name]: value });
  };

  const handleAddEmployee = async (e) => {
    e.preventDefault();
    try {
      const addEmployee = await employeeService.addEmployee(addNewEmployee);
      setEmployees([...employees, addEmployee]);
      setAddNewEmployee({
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
      });
    } catch (error) {
      console.error(error);
    }
  };

  const handleDeleteEmployee = async (employee) => {
    try {
      await employeeService.deleteEmployee(employee.id);
      setEmployees((prevEmployees) =>
        prevEmployees.filter((e) => e.id !== employee.id)
      );
      //alert("Employee deleted succesfully");
      setSelectedEmployee(null);
    } catch (error) {
      console.error(error);
      alert("Error deleting employee");
    }
  };

  return (
    <div>
      <div>
        {selectedEmployee ? (
          <EmployeePage
            employee={selectedEmployee}
            onBack={handleBackToList}
            onDelete={() => handleDeleteEmployee(selectedEmployee)}
          />
        ) : (
          <div>
            <EmployeeList
              employees={employees}
              onSelectEmployee={handleSelectEmployee}
            />
            <AddEmployeeForm
              handleInputChange={handleInputChange}
              handleAddEmployee={handleAddEmployee}
              newEmployee={addNewEmployee}
            />
          </div>
        )}
      </div>
    </div>
  );
};

export default App;
