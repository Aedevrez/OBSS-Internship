import React from "react";

class Button extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            count: 0
        }
    }

    increment = () => {
        let currentCount = this.state.count;
        this.setState({
            count: ++currentCount,
        });
    }

    render() {
        return (
            <>
                <p>Count: {this.state.count}</p>
                <button onClick = {this.increment}>
                    Increment Counter
                </button>
            </>
        )
    }
}

export default Button;
