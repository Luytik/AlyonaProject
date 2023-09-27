import { useState } from "react";

function MyForm() {
    const [nameAction, setNameAction] = useState("");


    const handleSubmit = (event) => {
        event.preventDefault();
        alert(`The name you entered was: ${nameAction}`);
    }

    return (
        <form onSubmit={handleSubmit}>

            <input
                type="text"
                value={nameAction}
                onChange={(e) => setNameAction(e.target.value)}
            />

            <input type="submit" />
        </form>
    )
}
export default MyForm;