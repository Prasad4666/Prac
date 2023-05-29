import nltk
from nltk.chat.util import Chat, reflections

from Chatbot import chat

pairs = [
    [
        r"How Are You",
        ["I am Fine what about You"]
    ],
    [
        r"My Name is (.)",
        ["Hello %1"]
    ],
]


def chatbot():
    print("Hello There")
    chat = Chat(pairs)
    chat.converse


if __name__ = "__main__":
    chatbot()
