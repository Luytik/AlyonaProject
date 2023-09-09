import ItemFinans from "./itemfinans";

const ListFinans = () => {
    const table = [{ name: "Доходи", category: "прродукти", summ: "125", date: "12.02.23", com: "lkdf kfd lfdv lfg fgfgfgfg fgbfgf fgbfgbfg" }]

    //const itemlist = table.map((item) => {
   //     <ItemFinans name={table[item].name} category={table[item].category} summ={table[item].summ} date={table[item].date}></ItemFinans>
    //    console.log(table[item].name)
    //}
    //) //перебирання однакових компонент для виводу



    return (
        <ul className="bg-[#52aea3] flex place-content-around p-3 rounded-xl items-stretch gap-4 items-center">
            <ItemFinans name={table[0].name} category={table[0].category} summ={table[0].summ} date={table[0].date} com={table[0].com}></ItemFinans>

        </ul>
    )

}

export default ListFinans;