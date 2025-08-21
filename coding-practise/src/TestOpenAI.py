from openai import OpenAI

client = OpenAI()

response = client.responses.create(
    model="gpt-5",
    input="Write a one line Story about a unicorn"

)

print(response.output_text)