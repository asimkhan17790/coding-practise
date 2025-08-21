import getpass
import os
from langchain_core.messages import HumanMessage, SystemMessage
from langchain.chat_models import init_chat_model


if not os.environ.get("OPENAI_API_KEY"):
    os.environ["OPENAI_API_KEY"] = getpass.getpass("Enter API key for OpenAI: ")

model = init_chat_model("gpt-4o-mini", model_provider="openai")


systemPrompt = "Translate the following English text into Hindi, but write the Hindi words using the English alphabet (Roman script). Do not translate into Devanagari. Keep the meaning natural and conversational.Example: 'How are you?' → 'Aap kaise hain.'. Return the text in json which has a field called \'result\' which will contain the response message"

systemPrompt2 = "Translate the English text into hindi"
messages = [
    SystemMessage(systemPrompt2),
    HumanMessage("Hello World!! How are you"),
]

response = model.invoke(messages)
print (response.content)

