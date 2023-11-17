import axios from "axios";

export const getCustomers = async () => {
    try {
        return await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/v1/customers`);
    } catch (e) {
        throw e;
    }
}

export const saveCustomer = async (customer) => {
    try {
        return await axios.post(
            `${import.meta.env.VITE_API_BASE_URL}/api/v1/customers`,
            customer
        );
    } catch (e) {
        throw e;
    }
}

export const deleteCustomer = async (id) => {
    try {
        return axios.delete(`${import.meta.env.VITE_API_BASE_URL}/api/v1/customers/${id}`);
    }catch (e){
        throw e;
    }
}

export const updateCustomer = async (id, update) => {
    try {
        return axios.put(`${import.meta.env.VITE_API_BASE_URL}/api/v1/customers/${id}`,
            update
        );
    }catch (e){
        throw e;
    }
}