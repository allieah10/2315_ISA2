from flask import Flask # type: ignore

app= Flask(__name__)

@app.route("/")
def print_roll():
    return "roll no is 2315"