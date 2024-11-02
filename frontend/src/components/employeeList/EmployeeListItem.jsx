import React from "react";

const EmployeeListItem = ({ employee, onSelect }) => (
  <li>
    <a
      href="#"
      onClick={(e) => {
        e.preventDefault();
        onSelect(employee);
      }}
    >
      {employee.firstName} {employee.lastName} - {employee.email}
    </a>
  </li>
);

export default EmployeeListItem;
