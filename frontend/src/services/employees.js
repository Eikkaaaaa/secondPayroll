import axios from 'axios';

const baseURL = '/api/employees';

const getAllEmployees = async () => {
    const response = await axios.get(baseURL, {
        headers: {
            'Accept': 'application/json'
        }
    });
    return response.data;
}

const getOneEmployee = async (employeeId) => {
    const response = await axios.get(`${baseURL}/${employeeId}`, {
        headers: {
            'Accept': 'application/json'
        }
    });
    return response.data;
}

const addEmployee = async (employee) => {
    const response = await axios.post(baseURL, employee, {
        headers: {
            'Accept': 'application/json'
        }
    });
    return response.data;
}

const updateEmployee = async (employeeId, employee) => {
    const response = await axios.put(`${baseURL}/${employeeId}`, employee, {
        headers: {
            'Accept': 'application/json'
        }
    });
    return response.data;
}

const deleteEmployee = async (employeeId) => {
    const response = await axios.delete(`${baseURL}/${employeeId}`, {
        headers: {
            'Accept': 'application/json'
        }
    });
    return response.data;
}

export default {
    getAllEmployees,
    getOneEmployee,
    addEmployee,
    updateEmployee,
    deleteEmployee,
};