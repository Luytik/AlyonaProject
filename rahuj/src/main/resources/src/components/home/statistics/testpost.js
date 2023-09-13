import { useState } from 'react';

function MyComponent() {
  const [data, setData] = useState({});

  const handleSubmit = (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);

    fetch('http://localhost:8080/api/categories/expenditureCategory', {
      method: 'POST',
      body: formData
    })
      .then((response) => response.text())
      .then((result) => {
        setData(result);
        console.log(setData(result));
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input className=" border-2" type="text" name="ExpenditureCategoryDTO" />
      <button className="bg-green h-14 w-24" type="submit">Submit</button>
    </form>
  );
}

export default MyComponent;