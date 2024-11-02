const AddEmployeeForm = ({
  handleInputChange,
  handleAddEmployee,
  newEmployee,
}) => {
  return (
    <div>
      <h3>Add new employee</h3>
      <form onSubmit={handleAddEmployee}>
        <input
          type="text"
          name="firstName"
          placeholder="First Name"
          value={newEmployee.firstName}
          onChange={handleInputChange}
          required
        />
        <input
          type="text"
          name="lastName"
          placeholder="Last Name"
          value={newEmployee.lastName}
          onChange={handleInputChange}
          required
        />
        <input
          type="text"
          name="email"
          placeholder="Email"
          value={newEmployee.email}
          onChange={handleInputChange}
          required
        />
        <input
          type="tel"
          name="phone"
          placeholder="Phone"
          value={newEmployee.phone}
          onChange={handleInputChange}
          required
        />
        <button type={"submit"}>Add employee</button>
      </form>
    </div>
  );
};

export default AddEmployeeForm;
