import React from "react";

function ShoppingTitle({title}) {
    return (
        <>
            <h2>{title}</h2>
        </>
    );
}

function ShoppingItem({name}) {
    return (
        <>
            <li>
                {name}
            </li>
        </>
    );
}

function ShoppingList({category, firstItem, secondItem, thirdItem}) {
    return (
        <>
            <div>
                <h4>{category}</h4>
                <ol>
                    <ShoppingItem name={firstItem} />
                    <ShoppingItem name={secondItem} />
                    <ShoppingItem name={thirdItem} />
                </ol>
            </div>
        </>
    )
}

function ShoppingApp({data}) {
    return (
        <>
            <div>
                <ShoppingTitle title="React Shop" />

                <ShoppingList
                    category={data[0].category}
                    firstItem={data[0].firstItem}
                    secondItem={data[0].secondItem}
                    thirdItem={data[0].thirdItem}
                />

                <ShoppingList
                    category={data[1].category}
                    firstItem={data[1].firstItem}
                    secondItem={data[1].secondItem}
                    thirdItem={data[1].thirdItem}
                />

                <ShoppingList
                    category={data[2].category}
                    firstItem={data[2].firstItem}
                    secondItem={data[2].secondItem}
                    thirdItem={data[2].thirdItem}
                />
            </div>
        </>
    )
}

export default ShoppingApp;