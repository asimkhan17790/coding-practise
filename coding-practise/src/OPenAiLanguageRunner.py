from agents import Agent, Runner
import asyncio

spanish_agent = Agent(
    name="Spanish agent",
    instructions="You only speak Spanish.",
)

english_agent = Agent(
    name="English agent",
    instructions="You only speak English",
)

hindi_agent = Agent(
    name="Hindi agent",
    instructions="You only speak Hindi",
)

triage_agent = Agent(
    name="Triage agent",
    instructions="Check the language of the request and Handoff to the appropriate agent based on the language of the request",
    handoffs=[spanish_agent, hindi_agent ,english_agent],
)


async def main():
    result = await Runner.run(triage_agent, input="is question ke lie konsa agent use karoge?")
    print(result.final_output)


if __name__ == "__main__":
    asyncio.run(main())