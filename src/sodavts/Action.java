package sodavts;

/**
 * Este enumerado identifica as várias ações que cada barco pode efetuar.
 *
 * @author Diogo Cruz_150221045 e Diogo Rocha_140275059
 */
public enum Action {
    BACIA, MARINA, TERMINAL_C, TERMINAL_Q, TERMINAL_P, PASSEIO, MAR;

    /**
     * Método que retorna uma Action dependendo da string recebida
     *
     * @param actionString string com o nome de uma acção
     * @return acção correspondente á string recebida
     */
    public static Action getEnum(String actionString) {
        switch (actionString) {
            case "Bacia":
                return BACIA;
            case "Marina":
                return MARINA;
            case "Mar":
                return MAR;
            case "Passeio":
                return PASSEIO;
            case "TerminalC":
                return TERMINAL_C;
            case "TerminalQ":
                return TERMINAL_Q;
            case "TerminalP":
                return TERMINAL_P;
            default:
                throw new IllegalArgumentException("Essa ação não existe");
        }
    }

    /**
     * Método que retorna uma string com a ação que o barco vai efetuar
     *
     * @return string com a ação que o barco vai efetuar.
     */
    @Override
    public String toString() {
        switch (this) {
            case BACIA:
                return "Bacia";
            case MARINA:
                return "Marina";
            case TERMINAL_C:
                return "Terminal C";
            case TERMINAL_Q:
                return "Terminal Q";
            case TERMINAL_P:
                return "Terminal P";
            case PASSEIO:
                return "Passeio";
            case MAR:
                return "Mar";
            default:
                throw new IllegalArgumentException("Essa ação não existe");
        }
    }
}
