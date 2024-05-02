package WEEK03;

public class SwitchOperator {
    public static void main(String[] args) {
        String str = "ChatGPT";

        switch(str) {
            case "ChatGPT":
                System.out.println("안녕하세요! 저는 오픈AI에서 개발된 대화형 인공지능 모델인 ChatGPT입니다.");
                break;
            case "Gemini":
                System.out.println("안녕하세요, 저는 Google AI에서 개발한 대화형 AI 또는 챗봇으로도 알려진 대규모 언어 모델입니다.");
                break;
            case "Copilot":
                System.out.println("안녕하세요! 저는 Microsoft Copilot이고, 사용자가 정보를 찾거나 질문에 답하거나 대화를 나누는 데 도움을 주는 AI 동반자입니다.");
                break;
            default:
                System.out.println("정보를 찾을 수 없습니다.");
                System.out.println("AI의 간단한 소개를 출력하고 있습니다.");
        }

        str = "Gemini";

        String madeBy = switch(str) {
            case "ChatGPT" -> {
                System.out.println("안녕하세요! 저는 오픈AI에서 개발된 대화형 인공지능 모델인 ChatGPT입니다.");
                yield "OpenAI";
            }
            case "Gemini" -> {
                System.out.println("안녕하세요, 저는 Google AI에서 개발한 대화형 AI 또는 챗봇으로도 알려진 대규모 언어 모델입니다.");
                yield "Google";
            }
            case "Copilot" -> {
                System.out.println("안녕하세요! 저는 Microsoft Copilot이고, 사용자가 정보를 찾거나 질문에 답하거나 대화를 나누는 데 도움을 주는 AI 동반자입니다.");
                yield "Microsoft";
            }
            default -> {
                System.out.println("정보를 찾을 수 없습니다.");
                System.out.println("AI의 간단한 소개를 출력하고 있습니다.");
                yield "?";
            }
        };

        System.out.println(madeBy);
    }
}
