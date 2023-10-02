import { useState } from "react";

function RegistrationForm() {

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

        fetch('http://localhost:8080/auth/signup', {
            method: 'POST',
            body: formData
        })
            .then((response) => response.text())
            .then((result) => {
                setInputs(result);
                //console.log(setInputs(result));
            });
    }

    return (
        <>

            <form className="grid grid-cols-2 gap-4 justify-items-center lg:px-20" onSubmit={handleSubmit}>
                <span className=""> Ваш Email: </span>
                <input
                    className=""
                    type="email"
                    name="email"
                    value={inputs.email || ""}
                    onChange={handleChange}
                />
                <span className=""> Ваш Login: </span>
                <input className=""
                    type="text"
                    name="login"
                    value={inputs.login || ""}
                    onChange={handleChange}
                />
                <span > Ваш пароль: </span>
                <input className=""
                    type="password"
                    name="password"
                    value={inputs.password || ""}
                    onChange={handleChange}
                />
                <div className="w-min mx-auto col-span-2">
                    <input type="submit" value="регістрація"
                        className=" bg-[#295545] text-[#fff] rounded-2xl p-3"
                    />
                </div>


            </form>

        </>

    )
}

export default RegistrationForm;