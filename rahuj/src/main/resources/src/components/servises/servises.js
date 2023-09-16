class Servises {
    _link = "http://localhost:8080/api/categories/"
    async getCategoryCost () {
        const data = await fetch(`${this._link}expenditureCategory`);
        return await data.json();
    }
}

export default Servises;