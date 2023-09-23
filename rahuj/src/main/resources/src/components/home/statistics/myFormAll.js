import { useState } from "react";

function MyFormAll() {
    const [inputs, setInputs] = useState({});

    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setInputs(values => ({ ...values, [name]: value }))
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log(inputs);
        const formData = new FormData(event.target);

        fetch('http://localhost:8080/api/expenditure/', {
          method: 'POST',
          body: formData
        })
          .then((response) => response.text())
          .then((result) => {
            setInputs(result);
            console.log(setInputs(result));
          });
    }

    return (
        <form onSubmit={handleSubmit}>

            <input
                type="text"
                name="expenditureCategoryDTO"
                value={inputs.expenditureCategoryDTO || ""}
                onChange={handleChange}
            />
            <input
                type="number"
                name="money"
                value={inputs.money || ""}
                onChange={handleChange}
            />
            <input
                type="date"
                name="date"
                value={inputs.date || ""}
                onChange={handleChange}
            />
            <textarea
            name="description"
            value={inputs.description || ""}
            onChange={handleChange}
            >
            </textarea>
            <input type="submit" />
        </form>
    )
}

export default MyFormAll;