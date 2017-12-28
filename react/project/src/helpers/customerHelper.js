const customerHelper = {
    addCustomer: (customers, newFirstName, newLastName, newEmail, newAddress, newActive, newStore) => [
        ...customers,
        {
            id: Math.floor((Math.random() * 10000) + 1),
            firstName: newFirstName,
            lastName: newLastName,
            email: newEmail,
            address: newAddress,
            active: newActive,
            store: newStore
        }
    ]
};

export default customerHelper;