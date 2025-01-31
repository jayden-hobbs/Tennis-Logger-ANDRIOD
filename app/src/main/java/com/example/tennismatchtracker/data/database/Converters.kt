class Converters {
    @TypeConverter
    fun fromHandedness(value: Handedness): String = value.name

    @TypeConverter
    fun toHandedness(value: String): Handedness = enumValueOf(value)

    @TypeConverter
    fun fromCompetitionType(value: CompetitionType): String = value.name

    @TypeConverter
    fun toCompetitionType(value: String): CompetitionType = enumValueOf(value)

    @TypeConverter
    fun fromMatchResult(value: MatchResult): String = value.name

    @TypeConverter
    fun toMatchResult(value: String): MatchResult = enumValueOf(value)

    @TypeConverter
    fun fromSurfaceType(value: SurfaceType?): String? = value?.name

    @TypeConverter
    fun toSurfaceType(value: String?): SurfaceType? = value?.let { enumValueOf(it) }

    @TypeConverter
    fun fromEnvironment(value: Environment?): String? = value?.name

    @TypeConverter
    fun toEnvironment(value: String?): Environment? = value?.let { enumValueOf(it) }

    @TypeConverter
    fun fromSetList(value: List<Set>): String = Json.encodeToString(value)

    @TypeConverter
    fun toSetList(value: String): List<Set> = Json.decodeFromString(value)
} 