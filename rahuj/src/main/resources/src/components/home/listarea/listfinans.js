import ItemFinans from "./itemfinans";

const ListFinans = () => {
    
    const table = [{ name: "Доходи", category: "прродукти", summ: "125", date: "12.11.22", com: "lkdf kfd lfdv lfg fgfgfgfg fgbfgf fgbfgbfg" },
    { name: "Доходи", category: "прродукти", summ: "125", date: "12.11.22", com: "lkdf kfd lfdfgbfg" },
    { name: "Доходи", category: "прродукти", summ: "125", date: "12.11.22", com: "lkdf kfdgfgfgfg fgbfgf fgbfgbfg" },
    { name: "Доходи", category: "прродукти", summ: "125", date: "12.11.22", com: "lkdf kfd lfdv lf" },]

    const tableItem = table.map((item) => <ItemFinans name={item.name} category={item.category} summ={item.summ} date={item.date} com={item.com} key={item.id}></ItemFinans>) //перебирання однакових компонент для виводу меню домашнього


    return (
        <>
            {tableItem}
        </>
    )

}

export default ListFinans;