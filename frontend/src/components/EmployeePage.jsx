import React from "react";

const EmployeePage = ({ employee, onBack, onDelete }) => (
  <div>
    <h2>Employee Details</h2>
    <p>
      Name: {employee.firstName} {employee.lastName}
    </p>
    <p>Email: {employee.email}</p>
    <p>Phone: {employee.phone}</p>
    <p>Created: {employee.created}</p>
    <button onClick={onDelete}>Delete employee</button>
    <button onClick={onBack}>Back to List</button>
  </div>
);

export default EmployeePage;
