import { useContext, useState } from "react";
import GetComeCategory from "./getComeCategory";
import { Login } from "../../../App";

function AddFilsToComePage() {
  const [inputs, setInputs] = useState({});
  const login = useContext(Login);

  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setInputs((values) => ({ ...values, [name]: value }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(inputs);
    const formData = new FormData(event.target);

    fetch(`http://localhost:8080/api/revenue/?login=${login[0]}`, {
      method: "POST",
      body: formData,
    })
      .then((response) => response.text())
      .then((result) => {
        setInputs(result);
        console.log(setInputs(result));
      });
  };

  return (
    <div className="bg-[#52aea3] flex flex-col p-3 rounded-xl">
      <form
        className="flex place-content-around items-stretch gap-4 items-center"
        onSubmit={handleSubmit}
      >
        <input
          className="lastcghange__item flex-1 self-center"
          type="date"
          name="date"
          value={inputs.date || ""}
          onChange={handleChange}
        />
        <input
          id="inputComeCategory"
          className="lastcghange__item flex-1 self-center"
          onClick={() => {
            document.querySelector("#comeCatHiden").className =
              "flex gap-2 flex-wrap";
          }}
          placeholder="категорія"
          type="text"
          name="revenueCategoryDTO"
          value={inputs.revenueCategoryDTO}
          onChange={handleChange}
        />
        <input
          className="lastcghange__item flex-1 self-center"
          placeholder="сума"
          type="number"
          name="money"
          value={inputs.money || ""}
          onChange={handleChange}
        />

        <textarea
          className="lastcghange__item flex-1 self-center"
          placeholder="коментар"
          name="description"
          value={inputs.description || ""}
          onChange={handleChange}
        ></textarea>
        <input
          type="submit"
          value="додати"
          className=" bg-[#295545] text-[#fff] rounded-2xl p-3"
        />
      </form>
      <div className="hidden" id="comeCatHiden">
        <GetComeCategory />
      </div>
    </div>
  );
}

export default AddFilsToComePage;
