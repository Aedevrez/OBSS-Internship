import React from "react"
import ShoppingApp from "./ShoppingApp";
import './App.css'

function App() {
  const shopData = [
    { category: "Yemek", firstItem: "Ekmek", secondItem: "Elma", thirdItem: "Peynir" },
    { category: "Kıyafet", firstItem: "Gömlek", secondItem: "Pantolon", thirdItem: "Kravat" },
    { category: "Malzeme", firstItem: "Kağıt", secondItem: "Bant", thirdItem: "Zımba" },
  ];

  return <ShoppingApp data={shopData} />;
}

export default App
