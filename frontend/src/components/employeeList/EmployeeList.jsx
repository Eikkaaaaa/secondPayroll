import React from "react";
import EmployeeListItem from "./EmployeeListItem.jsx";

const EmployeeList = ({ employees, onSelectEmployee }) => (
  <div>
    <h1>Employee List</h1>
    <ul>
      {employees.map((employee) => (
        <EmployeeListItem
          key={employee.id}
          employee={employee}
          onSelect={onSelectEmployee}
        />
      ))}
    </ul>
  </div>
);

export default EmployeeList;
